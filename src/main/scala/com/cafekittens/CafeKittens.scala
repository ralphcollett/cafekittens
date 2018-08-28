package com.cafekittens

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{BackendScope, Callback, ReactComponentB, ReactDOM, ReactEventI}
import org.scalajs.dom

import scala.util.Random

object CafeKittens {

  private val component = ReactComponentB[Unit]("Caffeine listings")
    .initialState(BeverageState(Beverage("", 0)))
    .renderBackend[BeverageOps]
    .build

  case class Beverage(name: String, mgOfCaffeine: Double)

  case class BeverageState(beverage: Beverage)

  private val beverages = Seq(
    Beverage("Tea", 2.2),
    Beverage("Coffee", 10),
    Beverage("Red Bull", 7),
    Beverage("Coca Cola", 5)
  )

  class BeverageOps($: BackendScope[Unit, BeverageState]) {

    private val beverageState = $.zoom(_.beverage)((s, x) => s.copy(beverage = x))

    def searchForBeverage(event: ReactEventI): Callback = {
      val randomBeverage = Random.shuffle(beverages).head
      beverageState.setState(randomBeverage)
    }

    def render(state: BeverageState) = {
      <.div(
        <.h1("Caffeine listings"),
        <.p(s"${state.beverage.name} ${state.beverage.mgOfCaffeine}"),
        <.button(^.`type` := "button",
          ^.onClick ==> searchForBeverage,
          "Search"
        ))
    }
  }

  def main(args: Array[String]): Unit = {
    ReactDOM.render(component(), dom.document.getElementById("playground"))
  }
}
