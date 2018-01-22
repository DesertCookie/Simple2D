/*
 * Copyright (c) 2018 Ruben Hahn (DesertCookie),
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions
 *    and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 *    conditions and the following disclaimer in the documentation and/or other materials provided
 *    with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package desertcookie.simple2d.core;


import desertcookie.simple2d.exceptions.SceneAlreadyRegisteredException;
import desertcookie.simple2d.exceptions.SceneNotRegisteredException;
import desertcookie.simple2d.input.InputHandler;
import desertcookie.simple2d.rendering.SimpleGraphics;

import java.util.HashMap;


/**
 * Klasse, die alle Spielszenen verwaltet.
 *
 * @since 0.1.9
 */
public class GameSceneHandler {
	
	
	private HashMap<Integer,GameScene> registeredScenes;
	private GameScene activeScene;
	
	
	/**
	 * Konstruiert neuen GameSceneHandler. Interner Konstruktor.
	 *
	 * @since 0.1.9
	 */
	GameSceneHandler() {
		registeredScenes = new HashMap<>();
		activeScene = new SplashScreen();
	}
	
	
	/**
	 * Fügt eine Szene zur Liste der registrierten GameScenes hinzu.
	 *
	 * @param scene Szene die registriert werden soll
	 * @since 0.1.9
	 */
	public void registerScene( GameScene scene ) {
		if( registeredScenes.containsKey( scene.getSceneId() ) )
			throw new SceneAlreadyRegisteredException();
		registeredScenes.put( scene.getSceneId(),scene );
	}
	
	/**
	 * Entfernt eine Szene von der Liste der registrierten GameScenes.
	 *
	 * @param sceneId Identifikator der Szene die entfernt werden soll
	 * @since 0.1.9
	 */
	public void removeScene( int sceneId ) {
		if( !registeredScenes.containsKey( sceneId ) )
			throw new SceneNotRegisteredException();
		registeredScenes.remove( sceneId );
	}
	
	/**
	 * Entfernt eine Szene von der Liste der registrierten GameScenes.
	 *
	 * @param scene Szene die entfernt werden soll
	 * @since 0.1.9
	 */
	public void removeScene( GameScene scene ) {
		removeScene( scene.getSceneId() );
	}
	
	/**
	 * Setzt die aktive Szene, die dann vom Game Loop geupdated und gerendert wird.
	 *
	 * @param scene Szene die als aktive gesetz werden soll
	 * @since 0.1.9
	 */
	public void setActiveScene( GameScene scene ) {
		activeScene.leaveScene();
		activeScene = null;
		scene.enterScene();
		activeScene = scene;
	}
	
	/**
	 * Setzt die registrierte Szene mit dieser Id als aktive Szene, die dann vom Game Loop geupdated und gerendert wird.
	 *
	 * @param sceneId Identifikator der Szene die als aktive gesetzt werden soll
	 * @since 0.1.9
	 */
	public void enterScene( int sceneId ) {
		if( !registeredScenes.containsKey( sceneId ) )
			throw new SceneNotRegisteredException();
		setActiveScene( registeredScenes.get( sceneId ) );
	}
	
	
	/**
	 * Updatet die aktive GameScene. Interne Methode.
	 *
	 * @param dt    Zeit seit dem letzten Update in Sekunden
	 * @param input Schnittstelle für Input
	 * @since 0.1.9
	 */
	void updateActiveScene( double dt,InputHandler input ) {
		if( activeScene != null )
			activeScene.update( dt,input );
	}
	
	/**
	 * Rendert die aktive GameScene. Interne Methode.
	 *
	 * @param graphics Schnittstelle für Rendering
	 * @since 0.1.9
	 */
	void renderActiveScene( SimpleGraphics graphics ) {
		if( activeScene != null )
			activeScene.render( graphics );
	}
	
	/**
	 * Ruft die exit()-Methode aller registrierten GameScenes auf. Interne Methode.
	 *
	 * @since 0.1.9
	 */
	void exitScenes() {
		for( GameScene scene : registeredScenes.values() )
			scene.exitScene();
	}
	
	/**
	 * Löscht die vom GameSceneHandler angehäuften Ressourcen. Interne Methode.
	 *
	 * @since 0.1.9
	 */
	void cleanUp() {
		registeredScenes.clear();
		activeScene = null;
	}
	
	
}
