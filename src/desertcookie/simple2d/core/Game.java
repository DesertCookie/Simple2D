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


import desertcookie.simple2d.Simple2D;
import desertcookie.simple2d.input.InputHandler;
import desertcookie.simple2d.rendering.SimpleGraphics;
import desertcookie.util.ExceptionHandler;
import desertcookie.util.LogWriter;

import java.awt.*;


/**
 * Hauptklasse des Spiels mit den Game Loops.
 *
 * @since 0.1.9
 */
public abstract class Game {
	
	
	private static Display display;
	private static GameSceneHandler sceneHandler;
	private static InputHandler inputHandler;
	private static LogWriter logWriter;
	
	private static boolean run;
	private static double maxTps, maxFps;
	private static double tps, fps;
	private static boolean drawDebug;
	
	
	/**
	 * Konstruiert neues Game mit Standardwerten für FPS- und TPS-Limit von 60Hz.
	 *
	 * @since 0.4.7
	 */
	public Game() {
		display = new Display();
		sceneHandler = new GameSceneHandler();
		inputHandler = new InputHandler();
		display.setInputListeners( inputHandler );
		logWriter = new LogWriter( "game.log","Dies ist eine automatisch generierte Log-Datei. Sie zeichnet alle wichtigen und außergewöhnlichen Vorkommnisse innerhalb des Spiels auf.\nRunning on: Simple2D v" + Simple2D.VERSION_STRING );
		ExceptionHandler.addLogWriter( logWriter );
		
		maxTps = 60;
		maxFps = 60;
	}
	
	
	/**
	 * @return Display dieses Spiels.
	 * @since 0.1.9
	 */
	public static Display getDisplay() {
		return display;
	}
	
	/**
	 * @return GameSceneHandler dieses Spiels.
	 * @since 0.1.9
	 */
	public static GameSceneHandler getSceneHandler() {
		return sceneHandler;
	}
	
	/**
	 * @return InputHandler dieses Spiels.
	 * @since 0.1.9
	 */
	public static InputHandler getInputHandler() {
		return inputHandler;
	}
	
	/**
	 * @return LogWriter dieses Spiels.
	 * @since 0.1.9
	 */
	public static LogWriter getLogWriter() {
		return logWriter;
	}
	
	/**
	 * @return Anzahl der momentanen Ticks pro Sekunde des Game Loops.
	 * @since 0.1.9
	 */
	public static double getTps() {
		return tps;
	}
	
	/**
	 * @return Anzahl der momentanen Bilder pro Sekunde des Game Loops.
	 * @since 0.1.9
	 */
	public static double getFps() {
		return fps;
	}
	
	
	/**
	 * @return {@code true} wenn der Game Loop momentan läuft.
	 * @since 0.3.4
	 */
	public boolean isRunning() {
		return run;
	}
	
	/**
	 * @return Anzahl der maximal zugelassenen Ticks pro Sekunde.
	 * @since 0.3.4
	 */
	public double getMaxTps() {
		return maxTps;
	}
	
	/**
	 * Setzt die Anzahl der maximal zugelassenen Ticks pro Sekunde.
	 *
	 * @param maxTps Maximale Ticks pro Sekunde
	 * @since 0.3.4
	 */
	public void setMaxTps( double maxTps ) {
		Game.maxTps = maxTps;
	}
	
	/**
	 * @return Anzahl der maximal zugelassenen Bilder pro Sekunde.
	 * @since 0.3.4
	 */
	public double getMaxFps() {
		return maxFps;
	}
	
	/**
	 * Setzt die Anzahl der maximal zugelassenen Bilder pro Sekunde.
	 *
	 * @param maxFps Maximale Bilder pro Sekunde
	 * @since 0.3.4
	 */
	public void setMaxFps( double maxFps ) {
		Game.maxFps = maxFps;
	}
	
	/**
	 * @return {@code true} wenn das Debug-Menü gerendert werden soll.
	 * @since 0.4.7
	 */
	public boolean getDrawDebug() {
		return drawDebug;
	}
	
	/**
	 * Setzt die Eigenschaft des Spiels, ob ein einfaches Debug-Menü mit TPS, FPS und Cursorposition gerendert werden soll.
	 *
	 * @param drawDebug {@code true} um das Debug-Menü gerendert werden soll
	 * @since 0.4.7
	 */
	public void setDrawDebug( boolean drawDebug ) {
		Game.drawDebug = drawDebug;
	}
	
	/**
	 * Startet das Spiel. Diese Methode sollte als letzte, innerhalb der Mainmethode aufgerufen werden, da nachfolgender Code erst nach Beendung des Spiels ausgeführt wird.
	 *
	 * @since 0.1.9
	 */
	public void startGame() {
		logWriter.write( "Starte spiel..." );
		run = true;
		display.prepareDisplay();
		display.setVisible( true );
		logWriter.write( "Spiel gestartet!" );
		
		updateLoop();
		renderLoop();
	}
	
	/**
	 * Stoppt das Spiel. Diese Methode kann entweder manuell aufgerufen werden, wird aber auch automatisch aufgerufen, wenn das Spielfenster geschlossen wird.
	 *
	 * @since 0.1.9
	 */
	public static void stopGame() {
		logWriter.write( "Stoppe spiel..." );
		run = false;
		sceneHandler.exitScenes();
		display.cleanUp();
		sceneHandler.cleanUp();
		logWriter.write( "Spiel gestoppt!" );
	}
	
	
	/**
	 * Update Loop (Game Loop 2).
	 *
	 * @since 0.1.9
	 */
	private static void updateLoop() {
		Thread thread = new Thread( new Runnable() {
			@Override
			public void run() {
				double[] deltaTime = new double[2];
				int currentPos = 0;
				final long TIME_PER_TICK = (long)(1e9 / maxTps);
				long lastTime = System.nanoTime();
				long thisTime;
				long elapsedTime;
				
				while( run ) {
					thisTime = System.nanoTime();
					elapsedTime = thisTime - lastTime;
					lastTime = thisTime;
					deltaTime[currentPos] = elapsedTime / 1e9;
					if( currentPos == 0 )
						currentPos = 1;
					else if( currentPos == 1 )
						currentPos = 0;
					sleep( TIME_PER_TICK - elapsedTime );
					if( elapsedTime < TIME_PER_TICK )
						tps = 1e9 / (elapsedTime + (TIME_PER_TICK - elapsedTime));
					else
						tps = 1e9 / elapsedTime;
					
					sceneHandler.updateActiveScene( (deltaTime[0] + deltaTime[1]),inputHandler );
				}
			}
		} );
		thread.start();
	}
	
	/**
	 * Render Loop (Game Loop 1).
	 *
	 * @since 0.1.9
	 */
	private static void renderLoop() {
		SimpleGraphics graphics = display.createSimpleGraphics();
		Font oldFont;
		Font debugFont = new Font( "Courier New",Font.PLAIN,15 );
		
		final long TIME_PER_TICK = (long)(1e9 / maxFps);
		long lastTime = System.nanoTime();
		long thisTime;
		long elapsedTime;
		
		while( run ) {
			thisTime = System.nanoTime();
			elapsedTime = thisTime - lastTime;
			lastTime = thisTime;
			sleep( TIME_PER_TICK - elapsedTime );
			if( elapsedTime < TIME_PER_TICK )
				fps = 1e9 / (elapsedTime + (TIME_PER_TICK - elapsedTime));
			else
				fps = 1e9 / elapsedTime;
			
			sceneHandler.renderActiveScene( graphics );
			oldFont = graphics.getFont();
			graphics.setFont( debugFont );
			drawDebug( graphics );
			graphics.setFont( oldFont );
			display.switchBuffers();
			graphics.resetBuffer();
			
			if( display.closed )
				run = false;
		}
		stopGame();
	}
	
	/**
	 * Lässt den aufrufenden Thread für die angegebene Zeit pausieren.
	 *
	 * @param time Zeit in Nanosekunden
	 * @since 0.1.9
	 */
	private static void sleep( long time ) {
		if( time <= 0 )
			return;
		int millis = (int)(time / 1e6);
		int nanos = (int)(time - millis * 1e6);
		try {
			Thread.sleep( millis,nanos );
		} catch( InterruptedException e ) {
			ExceptionHandler.handle( e,"Ein anderer Prozess hat das Spiel kurzzeitig angehalten",false );
			updateLoop();
		}
	}
	
	/**
	 * Rendert ein einfaches Debug-Menü.
	 *
	 * @param graphics Schnittstelle für Rendering
	 * @since 0.4.7
	 */
	private static void drawDebug( SimpleGraphics graphics ) {
		if( !drawDebug )
			return;
		graphics.setColor( new Color( 250,5,5 ) );
		graphics.drawString( String.format( "TPS: %.1f",tps ),5,15 );
		graphics.drawString( String.format( "FPS: %.1f",fps ),5,25 );
	}
	
	
}
