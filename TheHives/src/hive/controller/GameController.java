/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hive.controller;

import hive.model.game.Game;

/**
 *
 * @author Thomas
 */
public class GameController
{
    Game game;
    
    ActionSelection selection;
    
    public GameController(Game game)
    {
        this.game = game;
    }
}