package org.example;

import jakarta.servlet.http.HttpServletRequest;
import org.example.exceptions.GameNotFound;
import org.example.exceptions.PlayerNotFound;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;

@RestController
public class MyController {

    private HashMap<Integer, Game> games = new HashMap<>();

    MyController(){
        games.put(0,new Game(0,0));
    }

    @GetMapping("/wrestle/{gameId}")
    public Game getWrestle(@PathVariable int gameId){
        return getGame(gameId);
    }

    @PutMapping("/wrestle/{gameId}/{player}")
    public void putWrestle(@PathVariable int gameId, @PathVariable int player, HttpServletRequest request){
        Game game = games.get(gameId);
        switch(player){
            case 1 -> game.increment1();
            case 2 -> game.increment2();
            default -> throw new PlayerNotFound();
        }
        game.addStat(request.getHeader("user-agent"));
    }

    @PostMapping(value = "/wrestle/{gameId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGame(@RequestBody Game game, @PathVariable int gameId){
        games.put(gameId, game);
        return ResponseEntity
                .created(URI.create("/wrestle/"+gameId))
                .build();
    }

    @DeleteMapping("/wrestle/{gameId}")
    public void deleteWrestle(@PathVariable int gameId){
        Game game = games.get(gameId);
        game.raz();
    }

    @ExceptionHandler(GameNotFound.class)
    public ResponseEntity<String> handleException(){
        return ResponseEntity
                //.of(Optional.of("No game found"))
                .status(404).build();
    }

    private Game getGame(int gameId) {
        Game game = games.get(gameId);
        if(game == null){
            throw new GameNotFound();
        }
        return game;
    }

















}
