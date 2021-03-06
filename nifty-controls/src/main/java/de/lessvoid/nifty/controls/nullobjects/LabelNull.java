package de.lessvoid.nifty.controls.nullobjects;

import de.lessvoid.nifty.controls.Label;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.tools.Color;
import de.lessvoid.nifty.tools.SizeValue;

public class LabelNull implements Label {

  @Override
  public Element getElement() {
    return null;
  }

  @Override
  public String getId() {
    return "LabelNull";
  }

  @Override
  public void setId(final String id) {
  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public void setWidth(final SizeValue width) {
  }

  @Override
  public int getHeight() {
    return 0;
  }

  @Override
  public void setHeight(final SizeValue height) {
  }

  @Override
  public String getStyle() {
    return null;
  }

  @Override
  public void setStyle(final String style) {
  }

  @Override
  public void enable() {
  }

  @Override
  public void disable() {
  }

  @Override
  public void setEnabled(final boolean enabled) {
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  @Override
  public void setText(final String text) {
  }

  @Override
  public String getText() {
    return null;
  }

  @Override
  public void setColor(final Color color) {
  }

  @Override
  public Color getColor() {
    return null;
  }

  @Override
  public void setFocus() {
  }

  @Override
  public void setFocusable(final boolean focusable) {
  }

  @Override
  public boolean hasFocus() {
    return false;
  }

  @Override
  public void layoutCallback() {
  }

  @Override
  public boolean isBound() {
    return false;
  }
}
