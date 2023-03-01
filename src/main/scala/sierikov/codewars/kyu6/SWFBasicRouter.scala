package sierikov.codewars.kyu6

object SWFBasicRouter {
  case class Endpoint(path: String, method: String, f: () => String) {
    def canEqual(a: Any): Boolean = a.isInstanceOf[Endpoint]

    override def equals(that: Any): Boolean =
      that match {
        case that: Endpoint =>
          that.canEqual(this) &&
          this.path == that.path &&
          this.method == that.method
        case _ => false
      }
  }

  case class Router() {
    private var endpoints: List[Endpoint] = List.empty[Endpoint]
    def bind(path: String, method: String, f: () => String): Unit = {
      val endpoint = Endpoint(path, method, f)
      endpoints = endpoints.filterNot(_ == endpoint) :+ endpoint
    }

    def runRequest(path: String, method: String): String = endpoints
      .find(e => e.path == path && e.method == method)
      .map(_.f())
      .getOrElse("Error 404: Not Found")

  }
}
