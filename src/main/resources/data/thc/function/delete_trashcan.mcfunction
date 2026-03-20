# as trash can
    execute as @e[type=chest_minecart, tag=trash_can] run scoreboard players remove @s trashcan_expire 1 
    execute as @e[type=chest_minecart, tag=trash_can] if score @s trashcan_expire matches 0 run function thc:delete_junk
    execute as @e[type=chest_minecart, tag=trash_can] at @s if score @s trashcan_expire matches 0 run playsound block.composter.empty ambient @p ~ ~ ~ 1 1
    execute as @e[type=chest_minecart, tag=trash_can] if score @s trashcan_expire matches 0 run kill @s