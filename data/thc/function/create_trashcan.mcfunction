# as player at player
    summon minecraft:chest_minecart ^ ^0.5 ^0.5 {CustomNameVisible:true, CustomName:{text: "Trash Can",bold:True, color: "gray"}, Silent:true, NoGravity:True, Invulnerable:true,Tags:["trash_can", "init_trash"]}
    execute as @e[type=chest_minecart, tag=init_trash] run scoreboard players set @s trashcan_expire 10
    execute as @e[type=chest_minecart, tag=init_trash] run tag @s remove init_trash
    