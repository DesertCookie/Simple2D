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
import desertcookie.simple2d.textures.TextureLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;


/**
 * Klasse, mit deren Hilfe die Art des Fensters geändert werden kann.
 *
 * @since 0.1.9
 */
public class Display {
	
	
	private JFrame window;
	private JPanel drawingSurface;
	private BufferedImage buffer;
	
	/**
	 * {@code true} wenn das Fenster geschlossen ist (beendet).
	 *
	 * @since 0.1.9
	 */
	boolean closed = false;
	
	
	/**
	 * Konstruiert neues Display. Interner Konstruktor.
	 *
	 * @since 0.1.9
	 */
	Display() {
		window = new JFrame();
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing( WindowEvent e ) {
				closed = true;
				super.windowClosing( e );
			}
		} );
		drawingSurface = new JPanel();
		drawingSurface.setLocation( 0,0 );
	}
	
	
	/**
	 * @return Titel des Fenster.
	 * @since 0.3.4
	 */
	public String getTitle() {
		return window.getTitle();
	}
	
	/**
	 * Setzt den Titel des Fenster.
	 *
	 * @param title Titel des Fenster
	 * @since 0.1.9
	 */
	public void setTitle( String title ) {
		window.setTitle( title );
	}
	
	/**
	 * @return Horizontale Größe des Renderareals.
	 * @since 0.3.4
	 */
	public int getWidth() {
		return drawingSurface.getWidth();
	}
	
	/**
	 * Setzt die horizontale Größe des Renderareals.
	 *
	 * @param width Horizontale Größe in Pixeln
	 * @since 0.3.4
	 */
	public void setWidth( int width ) {
		drawingSurface.setSize( width,drawingSurface.getHeight() );
	}
	
	/**
	 * @return Vertikale Größe des Renderareals.
	 * @since 0.3.4
	 */
	public int getHeight() {
		return drawingSurface.getHeight();
	}
	
	/**
	 * Setzt die vertikale Größe des Renderareals.
	 *
	 * @param height Vertikale Größe in Pixeln
	 * @since 0.3.4
	 */
	public void setHeight( int height ) {
		drawingSurface.setSize( drawingSurface.getWidth(),height );
	}
	
	/**
	 * Setzt die Größe des Renderareals.
	 *
	 * @param width  Horizontale Größe in Pixeln
	 * @param height Vertikale Größe in Pixeln
	 * @since 0.1.9
	 */
	public void setSize( int width,int height ) {
		drawingSurface.setPreferredSize( new Dimension( width,height ) );
	}
	
	/**
	 * @return {@code true} wenn die Größe des Fensters vom Nutzer veränderbar ist.
	 * @since 0.3.4
	 */
	public boolean getResizable() {
		return window.isResizable();
	}
	
	/**
	 * Setzt die Eigenschaft des Fensters, die entscheidet, ob die Größe des Fensters vom Nutzer veränderbar ist.
	 *
	 * @param resizable {@code true} wenn die Größe des Fensters veränderbar sein soll
	 * @since 0.3.4
	 */
	public void setResizable( boolean resizable ) {
		window.setResizable( resizable );
	}
	
	
	/**
	 * @return Neu erstelltes SimpleGraphics-Objekt. Interne Methode.
	 * @since 0.1.9
	 */
	SimpleGraphics createSimpleGraphics() {
		return new SimpleGraphics( buffer.createGraphics() );
	}
	
	/**
	 * Bereitet das Fenster für die Benutzung vor. Interne Methode.
	 *
	 * @since 0.1.9
	 */
	void prepareDisplay() {
		window.setContentPane( drawingSurface );
		window.pack();
		window.setLocationRelativeTo( null );
		buffer = new BufferedImage( drawingSurface.getWidth(),drawingSurface.getHeight(),BufferedImage.TYPE_INT_ARGB );
		buffer = TextureLoader.toCompatibleImage( buffer );
	}
	
	/**
	 * Setzt die Sichtbarkeit des Fensters. Interne Methode.
	 *
	 * @param visible {@code true} wenn das Fenster sichtbar sein soll
	 * @since 0.1.9
	 */
	void setVisible( boolean visible ) {
		window.setVisible( visible );
	}
	
	/**
	 * Setzt die InputListener für Input. Interne Methode.
	 *
	 * @param input InputHandler der genutzt werden soll
	 * @since 0.1.9
	 */
	void setInputListeners( InputHandler input ) {
		drawingSurface.addKeyListener( input.getKeyboard() );
		drawingSurface.addMouseListener( input.getMouse() );
		drawingSurface.addMouseMotionListener( input.getMouseMovement() );
		drawingSurface.setFocusable( true );
	}
	
	/**
	 * Tauscht die Rendering-Buffer. Interne Methode.
	 *
	 * @since 0.1.9
	 */
	void switchBuffers() {
		drawingSurface.getGraphics().drawImage( buffer,0,0,drawingSurface.getWidth(),drawingSurface.getHeight(),null );
	}
	
	/**
	 * Löst die vom Fenster angehäuften Ressourcen. Interne Methode.
	 *
	 * @since 0.1.9
	 */
	void cleanUp() {
		window.setVisible( false );
		window.dispose();
		drawingSurface = null;
		buffer = null;
	}
	
	
}
