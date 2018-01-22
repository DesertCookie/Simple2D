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


import desertcookie.simple2d.input.InputHandler;
import desertcookie.simple2d.rendering.SimpleGraphics;


/**
 * Repräsentation einer einzelnen Spielszene.
 *
 * @since 0.1.9
 */
public abstract class GameScene {
	
	
	private int sceneId;
	
	
	/**
	 * Konstruiert neue GameScene.
	 *
	 * @param sceneId Identifikator dieser Spielszene
	 * @since 0.1.9
	 */
	public GameScene( int sceneId ) {
		this.sceneId = sceneId;
	}
	
	
	/**
	 * Methode für Update-Code, die regelmäßig vom Game Loop aufgerufen wird, wenn diese Szene die aktive Szene im GameSceneHandler ist.
	 *
	 * @param deltaTime Zeit seit dem letzten Update in Sekunden
	 * @param input     Schnittstelle für Input
	 * @since 0.1.9
	 */
	public abstract void update( double deltaTime,InputHandler input );
	
	/**
	 * Methode für Render-Code, die regelmäßig vom Game Loop aufgerufen wird, wenn diese Szene die aktive Szene im GameSceneHandler ist.
	 *
	 * @param graphics Schnittstelle für Rendering
	 * @since 0.1.9
	 */
	public abstract void render( SimpleGraphics graphics );
	
	
	/**
	 * Wird aufgerufen wenn diese Szene über den GameSceneHandler als aktive Szene gesetzt wird.
	 *
	 * @since 0.1.9
	 */
	public void enterScene() {
	
	}
	
	/**
	 * Wird aufgerufen wenn diese Szene über den GameSceneHandler als aktive Szene abgelöst wird.
	 *
	 * @since 0.1.9
	 */
	public void leaveScene() {
	
	}
	
	/**
	 * Wird aufgerufen wenn das Spiel beendet wird.
	 *
	 * @since 0.1.9
	 */
	public void exitScene() {
	
	}
	
	/**
	 * @return Identifikator dieser Spielszene.
	 * @since 0.1.9
	 */
	public int getSceneId() {
		return sceneId;
	}
	
	
}
