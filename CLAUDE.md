# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Minecraft Java Edition datapack called "Easy Trashcan" (namespace: `thc`). It lets players spawn a temporary chest minecart "trash can" that automatically destroys its contents and despawns after 10 seconds.

## Datapack Structure

- `pack.mcmeta` — Pack metadata. `pack_format` must match the target Minecraft version (currently 94 for 1.21.11).
- `data/minecraft/tags/function/` — `load.json` and `tick.json` hook into Minecraft's built-in function tag system.
- `data/thc/function/` — All datapack logic (the `thc` namespace).
- `data/global/advancement/` and `data/macro21kgb/advancement/` — Advancement tree for the "Installed Datapacks" menu (credits/attribution).

## How It Works

- **Tick loop** (`main.mcfunction`): Runs every tick. Enables the `trashcan` trigger for all players, spawns a trash can for any player who triggered it, then resets their score.
- **Slow loop** (`slow_main.mcfunction` → `delete_trashcan.mcfunction`): Runs every second via `schedule`. Decrements the `trashcan_expire` scoreboard timer on each trash can entity and kills those that reach 0 (after clearing their items and playing a sound).
- **Scoreboard objectives**: `trashcan` (trigger, player activation) and `trashcan_expire` (dummy, per-entity countdown timer).
- **Entity**: Trash cans are `chest_minecart` entities tagged `trash_can`.

## Development

### Installing for testing

Copy or symlink this repository into a Minecraft world's `datapacks/` folder, then run `/reload` in-game.

### Key commands in-game

- `/trigger trashcan set 1` — Spawn a trash can as a player.
- `/function thc:uninstall` — Remove all trash can entities and scoreboard objectives.
- `/reload` — Reload the datapack after making changes.

### Updating for new Minecraft versions

Update `pack_format` in `pack.mcmeta` to match the target version's expected format number.
