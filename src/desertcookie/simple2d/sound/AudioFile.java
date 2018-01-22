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

package desertcookie.simple2d.sound;


import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


/**
 * Repräsentation einer Audiodatei die sich starten, stoppen, pausieren und fortsetzen lässt.
 * @since 0.5.0
 */
public class AudioFile {
	
	
	private Clip clip;
	private int volume;
	private boolean loop;
	private int pausePosition;
	
	
	/**
	 * Konstruiert neue Audiodatei. Interner Konstruktor.
	 * @param clip Geladener Clip dieser Audio-Datei
	 * @since 0.5.0
	 */
	AudioFile(Clip clip) {
		this.clip = clip;
		clip.setLoopPoints( 0,-1 );
		volume = 100;
	}
	
	
	/**
	 *
	 * @return Lautstärke dieser Audiodatei zwischen 1 und 100.
	 * @since 0.5.0
	 */
	public int getVolume( ) {
		return volume;
	}
	
	/**
	 * Setzt die Lautstärke dieser Audiodatei zwischen 0 und 100.
	 * @param volume Lautstärkewert zwischen 1 und 100
	 * @since 0.5.0
	 */
	public void setVolume( int volume ) {
		this.volume = volume;
	}
	
	/**
	 *
	 * @return {@code true} wenn die Audiodatei in einer Dauerschleife läuft.
	 * @since 0.5.0
	 */
	public boolean getLoop() {
		return loop;
	}
	
	/**
	 * Setzt ob diese Audiodatei in einer Dauerschleife läuft.
	 * @param loop {@code true} wenn die Audio-Datei in einer Dauerschleife laufen soll
	 * @since 0.5.0
	 */
	public void setLoop( boolean loop ) {
		this.loop = loop;
		if(loop)
			clip.setLoopPoints( 0,-1 );
		else
			clip.setLoopPoints( 0,0 );
	}
	
	/**
	 *Startet diese Audiodatei vom Anfang an.
	 * @since 0.5.0
	 */
	public void start() {
		FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		float range = control.getMinimum();
		float result = range * (1 - volume / 100.0f);
		control.setValue(result);
		reset();
		clip.start();
	}
	
	/**
	 * Stoppt diese Audiodatei.
	 * @since 0.5.0
	 */
	public void stop() {
		clip.stop();
	}
	
	/**
	 * Startet diese Audiodatei von der mit {@link #pause()} gesetzten Position aus.
	 * @since 0.5.0
	 */
	public void resume() {
		clip.setFramePosition( pausePosition );
		clip.start();
	}
	
	/**
	 * Pausiert diese Audiodatei, sodass diese mit {@link #reset()} fortgesetzt werden kann.
	 * @since 0.5.0
	 */
	public void pause() {
		pausePosition = clip.getFramePosition();
		stop();
	}
	
	/**
	 * Setzt den Playback-Cursor an den Anfang dieser Audiodatei.
	 * @since 0.5.0
	 */
	public void reset() {
		clip.setFramePosition( 0 );
	}
	
	
}
