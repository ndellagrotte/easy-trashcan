scoreboard players enable @a trashcan
execute as @a[scores={trashcan=1..}] at @s run function thc:create_trashcan
scoreboard players set @a trashcan 0

execute as @e[tag=trash_can, type=minecraft:chest_minecart] run data modify entity @s Motion set value [0,0,0]
