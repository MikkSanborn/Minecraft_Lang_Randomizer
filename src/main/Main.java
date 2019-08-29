package main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import resources.TextFileReader;
import resources.TextFileWriter;

public class Main {
	public final static int seed = 100; // Change seed to get a different pack.
	public final static String languageFile = "en_us.json"; // United States English default. Use any language of your choice, just don't forget to put the file inside "Minecraft_Lang_Randomizer\\src\\resources", and then enter the name into the quotes on the left.
	
	// Each of the boolean represent a subtype that can be changed, but most should not be touched for the ease of use of the game. Some options may be unstable due to the format of the game's LANG files.
	// Feel free to change these
	public final static boolean biome = true;
	public final static boolean block = true;
	public final static boolean block_minecraft_banner = false; // technically a part of "block", but has 624 unique names
	public final static boolean color = true;
	public final static boolean effect = true;
	public final static boolean entity = true;
	public final static boolean item = true;
	public final static boolean itemGroup = true;
	public final static boolean merchant = true;
	public final static boolean subtitles = true;public final static boolean potion = true;
	public final static boolean sign = true;
	public final static boolean soundCategory = true;
	public final static boolean stat = true;
	
	// Add these if you choose. Most make the gameplay a bit weird and hard to navigate (i.e. options)
	public final static boolean gameMode = false;
	public final static boolean generator = false;
	public final static boolean key = false;
	public final static boolean options = false;
	public final static boolean resourcePack = false;
	public final static boolean resourcepack = false;
	public final static boolean spectatorMenu = false;
	
	// Change these if you wish. If any of these are true, it is HIGHLY LIKELY that the resourcepack will become invalid.
	public final static boolean addServer = false;
	public final static boolean advMode = false;
	public final static boolean advancement = false;
	public final static boolean advancements = false;
	public final static boolean argument = false;
	public final static boolean arguments = false;
	public final static boolean attribute = false;
	public final static boolean book = false;
	public final static boolean build = false;
	public final static boolean chat = false;
	public final static boolean clear = false;
	public final static boolean command = false;
	public final static boolean commands = false;
	public final static boolean connect = false;
	public final static boolean container = false;
	public final static boolean controls = false;
	public final static boolean createWorld = false;
	public final static boolean death = false;
	public final static boolean deathScreen = false;
	public final static boolean debug = false;
	public final static boolean demo = false;
	public final static boolean difficulty = false;
	public final static boolean disconnect = false;
	public final static boolean enchantment = false;
	public final static boolean event = false;
	public final static boolean filled_map = false;
	public final static boolean gui = false;
	public final static boolean inventory = false;
	public final static boolean jigsaw_block = false;
	public final static boolean lanServer = false;
	public final static boolean language = false;
	public final static boolean lectern = false;
	public final static boolean mcoServer = false;
	public final static boolean menu = false;
	public final static boolean mount = false;
	public final static boolean multiplayer = false;
	public final static boolean narrator = false;
	public final static boolean optimizeWorld = false;
	public final static boolean parsing = false;
	public final static boolean particle = false;
	public final static boolean permissions = false;
	public final static boolean realms = false;
	public final static boolean recipe = false;
	public final static boolean record = false;
	public final static boolean screenshot = false;
	public final static boolean selectServer = false;
	public final static boolean selectWorld = false;
	public final static boolean slot = false;
	public final static boolean stat_type = false;
	public final static boolean stats = false;
	public final static boolean structure_block = false;
	public final static boolean team = false;
	public final static boolean title = false;
	public final static boolean translation = false;
	public final static boolean tutorial = false;
	
	public final static ArrayList<String> lang_list = new ArrayList<String>();
	public final static String path = new File("").getAbsolutePath();
	public final static TextFileReader lang = new TextFileReader(path + "\\src\\resources\\" + languageFile);
	public final static ArrayList<String> lang_list_left = new ArrayList<String>();
	public final static ArrayList<String> lang_list_right = new ArrayList<String>();
	public final static ArrayList<String> lang_list_out = new ArrayList<String>();
	
	public static void main(String[] args) {
		String s = lang.nextLine();
		while (s != null) {
			lang_list.add(s);
			s = lang.nextLine();
		}
		
		// Sort alphabetically
		lang_list.sort(null);
		
		// Maintain the open curly brace, "{", at the beginning of the JSON file.
		lang_list.add(0, lang_list.remove(lang_list.size()-2));
		
		// Filter unnecessary pieces.
		for (int i = 0; i < lang_list.size(); /*i += 0*/) { // Remove any parts that will not be randomized. The game will fill in any missed items. ("false" in the list above will result in the object not being removed.)
			 if (!addServer && lang_list.get(i).contains("addServer")) {
				lang_list.remove(i);
			} else if (!advMode && lang_list.get(i).contains("advMode")) {
				lang_list.remove(i);
			} else if (!advancement && lang_list.get(i).contains("advancement")) {
				lang_list.remove(i);
			} else if (!advancements && lang_list.get(i).contains("advancements")) {
				lang_list.remove(i);
			} else if (!argument && lang_list.get(i).contains("argument")) {
				lang_list.remove(i);
			} else if (!arguments && lang_list.get(i).contains("arguments")) {
				lang_list.remove(i);
			} else if (!attribute && lang_list.get(i).contains("attribute")) {
				lang_list.remove(i);
			} else if (!biome && lang_list.get(i).contains("biome")) {
				lang_list.remove(i);
			} else if (!block_minecraft_banner && lang_list.get(i).contains("block.minecraft.banner.")) { // "block.minecraft.banner." needs to be before "block", due to the encompassing nature of "block" being a broader term, used inside "block.minecraft.name."
				lang_list.remove(i);
			} else if (!block && lang_list.get(i).contains("block")) {
				lang_list.remove(i);
			} else if (!book && lang_list.get(i).contains("book")) {
				lang_list.remove(i);
			} else if (!build && lang_list.get(i).contains("build")) {
				lang_list.remove(i);
			} else if (!chat && lang_list.get(i).contains("chat")) {
				lang_list.remove(i);
			} else if (!clear && lang_list.get(i).contains("clear")) {
				lang_list.remove(i);
			} else if (!color && lang_list.get(i).contains("color")) {
				lang_list.remove(i);
			} else if (!command && lang_list.get(i).contains("command")) {
				lang_list.remove(i);
			} else if (!commands && lang_list.get(i).contains("commands")) {
				lang_list.remove(i);
			} else if (!connect && lang_list.get(i).contains("connect")) {
				lang_list.remove(i);
			} else if (!container && lang_list.get(i).contains("container")) {
				lang_list.remove(i);
			} else if (!controls && lang_list.get(i).contains("controls")) {
				lang_list.remove(i);
			} else if (!createWorld && lang_list.get(i).contains("createWorld")) {
				lang_list.remove(i);
			} else if (!death && lang_list.get(i).contains("death")) {
				lang_list.remove(i);
			} else if (!deathScreen && lang_list.get(i).contains("deathScreen")) {
				lang_list.remove(i);
			} else if (!debug && lang_list.get(i).contains("debug")) {
				lang_list.remove(i);
			} else if (!demo && lang_list.get(i).contains("demo")) {
				lang_list.remove(i);
			} else if (!difficulty && lang_list.get(i).contains("difficulty")) {
				lang_list.remove(i);
			} else if (!disconnect && lang_list.get(i).contains("disconnect")) {
				lang_list.remove(i);
			} else if (!effect && lang_list.get(i).contains("effect")) {
				lang_list.remove(i);
			} else if (!enchantment && lang_list.get(i).contains("enchantment")) {
				lang_list.remove(i);
			} else if (!entity && lang_list.get(i).contains("entity")) {
				lang_list.remove(i);
			} else if (!event && lang_list.get(i).contains("event")) {
				lang_list.remove(i);
			} else if (!filled_map && lang_list.get(i).contains("filled_map")) {
				lang_list.remove(i);
			} else if (!gameMode && lang_list.get(i).contains("gameMode")) {
				lang_list.remove(i);
			} else if (!generator && lang_list.get(i).contains("generator")) {
				lang_list.remove(i);
			} else if (!gui && lang_list.get(i).contains("gui")) {
				lang_list.remove(i);
			} else if (!inventory && lang_list.get(i).contains("inventory")) {
				lang_list.remove(i);
			} else if (!item && lang_list.get(i).contains("item")) {
				lang_list.remove(i);
			} else if (!itemGroup && lang_list.get(i).contains("itemGroup")) {
				lang_list.remove(i);
			} else if (!jigsaw_block && lang_list.get(i).contains("jigsaw_block")) {
				lang_list.remove(i);
			} else if (!key && lang_list.get(i).contains("key")) {
				lang_list.remove(i);
			} else if (!lanServer && lang_list.get(i).contains("lanServer")) {
				lang_list.remove(i);
			} else if (!language && lang_list.get(i).contains("language")) {
				lang_list.remove(i);
			} else if (!lectern && lang_list.get(i).contains("lectern")) {
				lang_list.remove(i);
			} else if (!mcoServer && lang_list.get(i).contains("mcoServer")) {
				lang_list.remove(i);
			} else if (!menu && lang_list.get(i).contains("menu")) {
				lang_list.remove(i);
			} else if (!merchant && lang_list.get(i).contains("merchant")) {
				lang_list.remove(i);
			} else if (!mount && lang_list.get(i).contains("mount")) {
				lang_list.remove(i);
			} else if (!multiplayer && lang_list.get(i).contains("multiplayer")) {
				lang_list.remove(i);
			} else if (!narrator && lang_list.get(i).contains("narrator")) {
				lang_list.remove(i);
			} else if (!optimizeWorld && lang_list.get(i).contains("optimizeWorld")) {
				lang_list.remove(i);
			} else if (!options && lang_list.get(i).contains("options")) {
				lang_list.remove(i);
			} else if (!parsing && lang_list.get(i).contains("parsing")) {
				lang_list.remove(i);
			} else if (!particle && lang_list.get(i).contains("particle")) {
				lang_list.remove(i);
			} else if (!permissions && lang_list.get(i).contains("permissions")) {
				lang_list.remove(i);
			} else if (!potion && lang_list.get(i).contains("potion")) {
				lang_list.remove(i);
			} else if (!realms && lang_list.get(i).contains("realms")) {
				lang_list.remove(i);
			} else if (!recipe && lang_list.get(i).contains("recipe")) {
				lang_list.remove(i);
			} else if (!record && lang_list.get(i).contains("record")) {
				lang_list.remove(i);
			} else if (!resourcePack && lang_list.get(i).contains("resourcePack")) {
				lang_list.remove(i);
			} else if (!resourcepack && lang_list.get(i).contains("resourcepack")) {
				lang_list.remove(i);
			} else if (!screenshot && lang_list.get(i).contains("screenshot")) {
				lang_list.remove(i);
			} else if (!selectServer && lang_list.get(i).contains("selectServer")) {
				lang_list.remove(i);
			} else if (!selectWorld && lang_list.get(i).contains("selectWorld")) {
				lang_list.remove(i);
			} else if (!sign && lang_list.get(i).contains("sign")) {
				lang_list.remove(i);
			} else if (!slot && lang_list.get(i).contains("slot")) {
				lang_list.remove(i);
			} else if (!soundCategory && lang_list.get(i).contains("soundCategory")) {
				lang_list.remove(i);
			} else if (!spectatorMenu && lang_list.get(i).contains("spectatorMenu")) {
				lang_list.remove(i);
			} else if (!stat && lang_list.get(i).contains("stat")) {
				lang_list.remove(i);
			} else if (!stat_type && lang_list.get(i).contains("stat_type")) {
				lang_list.remove(i);
			} else if (!stats && lang_list.get(i).contains("stats")) {
				lang_list.remove(i);
			} else if (!structure_block && lang_list.get(i).contains("structure_block")) {
				lang_list.remove(i);
			} else if (!subtitles && lang_list.get(i).contains("subtitles")) {
				lang_list.remove(i);
			} else if (!team && lang_list.get(i).contains("team")) {
				lang_list.remove(i);
			} else if (!title && lang_list.get(i).contains("title")) {
				lang_list.remove(i);
			} else if (!translation && lang_list.get(i).contains("translation")) {
				lang_list.remove(i);
			} else if (!tutorial && lang_list.get(i).contains("tutorial")) {
				lang_list.remove(i);
			} else {
				// If none removed, continue forward.
				i++;
			}
		}
		
		// Get left and right sides of argument separated.
		for (int i = 1; i < lang_list.size()-1; i++) { // ignore "{" and "}", at pos 0, and len
			lang_list_left.add(lang_list.get(i).substring(0, lang_list.get(i).indexOf(":"))); // Argument left of the colon
			lang_list_right.add(lang_list.get(i).substring(lang_list.get(i).indexOf(":")+1, (lang_list.get(i).lastIndexOf(",") > 0 ? lang_list.get(i).lastIndexOf(","):lang_list.get(i).length()))); // Argument right of the colon, without a comma. SOME ARGS HAVE COMMAS!!!!
		}

		// Randomize
		System.out.println("Randomizing!");
		while(lang_list_left.size() > 1) { // Generate two seed-based numbers, "l" and "r", and join the two elements.
			int l;
			try {
				l = lang_list_left.size()*(seed>>1)+413;
			} catch (ArithmeticException e) {
				l = lang_list_left.size()*3>>1;
			}
			int r;
			try {
				r = lang_list_right.size()*2*(seed>>2)-113;
			} catch (ArithmeticException e) {
				r = lang_list_left.size()/14;
			}
			l = (l < 0 ? -l:l)%lang_list_left.size();
			r = (r < 0 ? -r:r)%lang_list_right.size();
			
			if (l == r) System.out.println("same, " + lang_list_left.size());

			lang_list_out.add(lang_list_left.remove(l) + ":" + lang_list_right.remove(r) + ",");
		}
		lang_list_out.add(lang_list_left.remove(0) + ":" + lang_list_right.remove(0)); // no comma on last arg.
		
		lang_list_out.add(0, "{");
		lang_list_out.add("}");
		
		System.out.println("Randomized!");
		
		System.out.println("Writing...");
		// Write to JSON in the file tree
		try {
			File folders = new File(path + "\\src\\out\\Shuffled Language " + seed + "\\assets\\minecraft\\lang");
			if (!folders.exists()) {
				if (folders.mkdirs()) {
					System.out.println("Multiple directories are created!");
				} else {
					System.out.println("Failed to create multiple directories!");
				}
			}
			TextFileWriter.write(path + "\\src\\out\\Shuffled Language " + seed + "\\assets\\minecraft\\lang\\" + languageFile, lang_list_out);
			TextFileWriter.write(path + "\\src\\out\\Shuffled Language " + seed + "\\pack.mcmeta", "{\r\n  \"pack\": {\r\n    \"pack_format\": 4,\r\n    \"description\": \"1.14 pack that shuffles text from the lang files. Seed: " + seed + "\"\r\n  }\r\n}");
		} catch (IOException e) {
			System.out.println("Failed to write.");
			e.printStackTrace();
		}
		System.out.println("Done writing. Resource Pack: \"Shuffled Language " + seed + "\" created!");
		System.out.println("Location: " + path + "\\src\\out\\Shuffled Language " + seed);
	}
	
}

/*
"block.minecraft.banner."

addServer
advMode
advancement
advancements
argument
arguments
attribute
biome
block
book
build
chat
clear
color
command
commands
connect
container
controls
createWorld
death
deathScreen
debug
demo
difficulty
disconnect
effect
enchantment
entity
event
filled_map
gameMode
generator
gui
inventory
item
itemGroup
jigsaw_block
key
lanServer
language
lectern
mcoServer
menu
merchant
mount
multiplayer
narrator
optimizeWorld
options
parsing
particle
permissions
potion
realms
recipe
record
resourcePack
resourcepack
screenshot
selectServer
selectWorld
sign
slot
soundCategory
spectatorMenu
stat
stat_type
stats
structure_block
subtitles
team
title
translation
tutorial
*/
