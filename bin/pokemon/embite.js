pokemon.register_pokemon("Embite");

Embite.register_image_front("PokemonChrome/Pictures/Sprites/Pokemon/Embite.png");
Embite.register_image_back("PokemonChrome/Pictures/Sprites/PokemonB/EmbiteB.png");

//Using torchic stats //???
Embite.set_base_hp(45);
Embite.set_base_attack(60);
Embite.set_base_defense(40);
Embite.set_base_sp_attack(70);
Embite.set_base_sp_defense(50);
Embite.set_base_speed(45);

Embite.on_spawn = function(level){
	THIS.set_type("Fire");
	set_iv_stats();
	
	
}

Embite.on_level = function(level){
	THIS.set_max_hp();
	
	
	
	
}