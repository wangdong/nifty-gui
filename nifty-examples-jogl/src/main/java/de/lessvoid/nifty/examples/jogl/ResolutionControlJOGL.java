package de.lessvoid.nifty.examples.jogl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.jogamp.newt.opengl.GLWindow;
import de.lessvoid.nifty.examples.jogl.ResolutionControlJOGL.Resolution;
import de.lessvoid.nifty.examples.resolution.ResolutionControl;

public class ResolutionControlJOGL implements ResolutionControl<Resolution> {
  private final GLWindow window;
  private final List<Resolution> resolutions;
  private Resolution current;

  public ResolutionControlJOGL(final GLWindow window) {
    this.window = window;
    this.current = new Resolution(1024, 768);
    this.resolutions = Arrays.asList(
        new Resolution(640, 480),
        new Resolution(800, 600),
        current,
        new Resolution(1280, 1024));
  }

  @Override
  public Collection<Resolution> getResolutions() {
    return resolutions;
  }

  @Override
  public void setResolution(final Resolution newResolution) {
    newResolution.apply(window);
    current = newResolution;
  }

  @Override
  public Resolution getCurrentResolution() {
    return current;
  }

  public static class Resolution {
    private final int width;
    private final int height;

    public Resolution(final int width, final int height) {
      this.width = width;
      this.height = height;
    }

    public void apply(final GLWindow window) {
      window.setSize(width, height);

      GL gl = window.getGL();
      gl.glViewport(0, 0, width, height);

      if (gl.isGL2()) {
        GL2 gl2 = gl.getGL2();
        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();
        gl2.glOrtho(0, width, height, 0, -9999, 9999);

        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        gl2.glLoadIdentity();
      }
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + height;
      result = prime * result + width;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Resolution other = (Resolution) obj;
      if (height != other.height)
        return false;
      if (width != other.width)
        return false;
      return true;
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder();
      result.append(width);
      result.append(" x ");
      result.append(height);
      return result.toString();
    }
  }
}
