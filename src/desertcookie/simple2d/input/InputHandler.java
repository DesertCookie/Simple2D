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

package desertcookie.simple2d.input;


/**
 * Klasse für Keyboard- und Mausinput.
 *
 * @since 0.1.9
 */
public class InputHandler {
	
	
	private static Keyboard keyboard;
	private static Mouse mouse;
	private static MouseMovement mouseMovement;
	
	/**
	 * Liste der Keyboard-Tasten.
	 *
	 * @since 0.1.9
	 */
	static boolean[] keyboardKeys;
	/**
	 * Liste der Maus-Tasten.
	 *
	 * @since 0.3.4
	 */
	static boolean[] mouseButtons;
	
	/**
	 * Cursorposition.
	 *
	 * @since 0.3.4
	 */
	static int mouseX, mouseY;
	/**
	 * Klicks die das Mausrad bewegt wurde.
	 *
	 * @since 0.3.4
	 */
	static int mouseWheelDelta;
	
	/**
	 * Cursorposition als die linke Maustaste gedrückt wurde.
	 *
	 * @since 0.3.4
	 */
	static int mouseXDragStart, mouseYDragStart;
	/**
	 * Anzahl Pixel, die der Cursor seit dem Drücken der linken Maustaste bewegt wurde.
	 *
	 * @since 0.3.4
	 */
	static int mouseXDragDelta, mouseYDragDelta;
	
	
	/**
	 * Konstruiert neuen InputHandler. Interner Konstruktor.
	 *
	 * @since 0.1.9
	 */
	public InputHandler() {
		keyboard = new Keyboard();
		mouse = new Mouse();
		mouseMovement = new MouseMovement();
		keyboardKeys = new boolean[512];
		mouseButtons = new boolean[16];
	}
	
	
	/**
	 * @param keyCode Taste die überprüft werden soll
	 * @return {@code true} wenn die angegebene Taste momentan gedrückt wird.
	 * @since 0.1.9
	 */
	public boolean isKeyDown( int keyCode ) {
		return keyboardKeys[keyCode];
	}
	
	/**
	 * @param buttonCode Button der überprüft werden soll
	 * @return {@code true} wenn die angegebene Maustaste momentan gedrückt wird.
	 * @since 0.4.7
	 */
	public boolean isButtonDown( int buttonCode ) {
		return mouseButtons[buttonCode];
	}
	
	/**
	 * @return Horizontale Position des Cursors innerhalb des Fensters in Pixeln.
	 * @since 0.3.4
	 */
	public static int getMouseX() {
		return mouseX;
	}
	
	/**
	 * @return Vertikale Position des Cursors innerhalb des Fensters in Pixeln.
	 * @since 0.3.4
	 */
	public static int getMouseY() {
		return mouseY;
	}
	
	/**
	 * @return Anzahl der Klicks die das Mausrad bewegt wurde.
	 * @since 0.3.4
	 */
	public static int getMouseWheelDelta() {
		return mouseWheelDelta;
	}
	
	
	/**
	 * @return Keyboard dieses InputHandlers. Interne Methode.
	 * @since 0.1.9
	 */
	public Keyboard getKeyboard() {
		return keyboard;
	}
	
	/**
	 * @return Maus dieses InputHandlers. Interne Methode.
	 * @since 0.3.4
	 */
	public Mouse getMouse() {
		return mouse;
	}
	
	/**
	 * @return MausMovement dieses InputHandlers. Interne Methode.
	 * @since 0.4.7
	 */
	public MouseMovement getMouseMovement() {
		return mouseMovement;
	}
	
	
}
