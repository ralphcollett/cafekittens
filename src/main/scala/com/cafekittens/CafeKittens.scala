package com.cafekittens

import org.querki.jquery._

object CafeKittens {

  def main(args: Array[String]): Unit = {
    $("""<button type="button">Click me!</button>""")
      .click(() => addClickedMessage())
      .appendTo($("body"))

    $("#click-me-button").click(() => addClickedMessage())
  }

  def addClickedMessage(): Unit = {
    $("body").append("<p>You clicked the button!</p>")
  }
}
