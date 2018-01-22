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


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Repräsentation der Tastatur.
 *
 * @since 0.1.9
 */
public class Keyboard extends KeyAdapter {
	
	
	/**
	 * Standard Buchstabentasten.
	 *
	 * @since 0.1.9
	 */
	public static final int A = KeyEvent.VK_A, B = KeyEvent.VK_B, C = KeyEvent.VK_C, D = KeyEvent.VK_D, E = KeyEvent.VK_E, F = KeyEvent.VK_F, G = KeyEvent.VK_G, H = KeyEvent.VK_H, I = KeyEvent.VK_I, J = KeyEvent.VK_J, K = KeyEvent.VK_K, L = KeyEvent.VK_L, M = KeyEvent.VK_M, N = KeyEvent.VK_N, O = KeyEvent.VK_O, P = KeyEvent.VK_P, Q = KeyEvent.VK_Q, R = KeyEvent.VK_R, S = KeyEvent.VK_S, T = KeyEvent.VK_T, U = KeyEvent.VK_U, V = KeyEvent.VK_V, W = KeyEvent.VK_W, X = KeyEvent.VK_X, Y = KeyEvent.VK_Y, Z = KeyEvent.VK_Z;
	/**
	 * Nummertasten.
	 *
	 * @since 0.3.4
	 */
	public static final int NO1 = KeyEvent.VK_1, NO2 = KeyEvent.VK_2, NO3 = KeyEvent.VK_3, NO4 = KeyEvent.VK_4, NO5 = KeyEvent.VK_5, NO6 = KeyEvent.VK_6, NO7 = KeyEvent.VK_7, NO8 = KeyEvent.VK_8, NO9 = KeyEvent.VK_9, NO0 = KeyEvent.VK_0;
	/**
	 * Keypad Nummern.
	 *
	 * @since 0.3.4
	 */
	public static final int KEYPAD1 = KeyEvent.VK_NUMPAD1, KEYPAD2 = KeyEvent.VK_NUMPAD2, KEYPAD3 = KeyEvent.VK_NUMPAD3, KEYPAD4 = KeyEvent.VK_NUMPAD4, KEYPAD5 = KeyEvent.VK_NUMPAD5, KEYPAD6 = KeyEvent.VK_NUMPAD6, KEYPAD7 = KeyEvent.VK_NUMPAD7, KEYPAD8 = KeyEvent.VK_NUMPAD8, KEYPAD9 = KeyEvent.VK_NUMPAD9, KEYPAD0 = KeyEvent.VK_NUMPAD0;
	/**
	 * Aktionstasten.
	 *
	 * @since 0.3.4
	 */
	public static final int ESC = KeyEvent.VK_ESCAPE, TAB = KeyEvent.VK_TAB, CAPS_LOCK = KeyEvent.VK_CAPS_LOCK, SHIFT_LEFT = KeyEvent.VK_SHIFT, CTRL_LEFT = KeyEvent.VK_CONTROL, WINDOWS_LEFt = KeyEvent.VK_WINDOWS, ALT_LEFT = KeyEvent.VK_ALT, SPACE = KeyEvent.VK_SPACE, ALT_GR = KeyEvent.VK_ALT_GRAPH, ENTER = KeyEvent.VK_ENTER, DELETE = KeyEvent.VK_DELETE;
	/**
	 * F-Tasten.
	 *
	 * @since 0.3.4
	 */
	public static final int F1 = KeyEvent.VK_F1, F2 = KeyEvent.VK_F2, F3 = KeyEvent.VK_F3, F4 = KeyEvent.VK_F4, F5 = KeyEvent.VK_F5, F6 = KeyEvent.VK_F6, F7 = KeyEvent.VK_F7, F8 = KeyEvent.VK_F8, F9 = KeyEvent.VK_F9, F10 = KeyEvent.VK_F10, F11 = KeyEvent.VK_F11, F12 = KeyEvent.VK_F12;
	/**
	 * Pfeiltasten.
	 *
	 * @since 0.3.4
	 */
	public static final int UP = KeyEvent.VK_UP, LEFT = KeyEvent.VK_LEFT, DOWN = KeyEvent.VK_DOWN, RIGHT = KeyEvent.VK_RIGHT;
	
	
	/**
	 * Konstruiert neues Keyborad. Interner Konstruktor.
	 *
	 * @since 0.1.9
	 */
	Keyboard() { }
	
	
	@Override
	public void keyPressed( KeyEvent e ) {
		super.keyPressed( e );
		InputHandler.keyboardKeys[e.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased( KeyEvent e ) {
		super.keyReleased( e );
		InputHandler.keyboardKeys[e.getKeyCode()] = false;
	}
	
	
}
