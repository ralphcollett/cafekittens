package com.cafekittens

import org.scalajs.dom
import dom.document

object CafeKittens {

  def main(args: Array[String]): Unit = {
    appendPar(document.body, "meow!")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

}
