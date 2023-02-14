package plugin.SuperSpring;


import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;


import static java.lang.Math.round;


public class MoveListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();

        if (player.isSprinting()){
            if (player.getWalkSpeed() < 0.99) {
                //Each tick add extra speed while springing
                player.setWalkSpeed(player.getWalkSpeed() + 0.0025F);
            }
            if (player.getWalkSpeed() > 0.6){
                Location loc_standing_plus_y = event.getPlayer().getLocation();
                Block standing_block = loc_standing_plus_y.getBlock();

                //Burn a block player standing
                if (standing_block.getType() == Material.AIR) {
                    standing_block.setType(Material.FIRE);
                    player.addPotionEffect(PotionEffectType.FIRE_RESISTANCE.createEffect(5, 1));
                    player.playEffect(player.getLocation(), Effect.LAVA_INTERACT,1);
                }
            }
            if (player.getWalkSpeed() > 0.4) {
                //Particle effect
                player.spawnParticle(Particle.FLAME, player.getLocation().clone().subtract(0, 1, 0), round(5F * player.getWalkSpeed() * player.getWalkSpeed()), 1, 1, 1);
            }
        }
        else{
            //Set default walk speed
            player.setWalkSpeed(0.2F);
        }

    }

}
