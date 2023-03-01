package sierikov.codewars.kyu6

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sierikov.codewars.kyu6.SWFBasicRouter._

class SWFBasicRouterSuite extends AnyFunSuite with Matchers {

  test("handle GET routs") {
    val router = new Router()
    router.bind("/hello", "GET", () => "hello world")
    router.bind("/login", "GET", () => "Please log-in.")
    assert(router.runRequest("/hello", "GET") == "hello world")
    assert(router.runRequest("/login", "GET") == "Please log-in.")
  }

  test("handle POST routes") {
    val router = new Router()
    router.bind("/vote", "POST", () => "Voted.")
    router.bind("/comment", "POST", () => "Comment sent.")
    assert(router.runRequest("/vote", "POST") == "Voted.")
    assert(router.runRequest("/comment", "POST") == "Comment sent.")
  }

  test("handle mixed routes") {
    val router = new Router()
    router.bind("/login", "GET", () => "Please log-in.")
    router.bind("/login", "POST", () => "Logging-in.")
    assert(router.runRequest("/login", "GET") == "Please log-in.")
    assert(router.runRequest("/login", "POST") == "Logging-in.")
  }

  test("return 404 for non-existing routes") {
    val router = new Router()
    assert(router.runRequest("/this-url-does-not-exist", "GET") == "Error 404: Not Found")
  }

  test("modify existing routes") {
    val router = new Router()
    router.bind("/page", "GET", () => "First binding.")
    router.bind("/page", "GET", () => "Modified binding.")
    assert(router.runRequest("/page", "GET") == "Modified binding.")
  }
}
