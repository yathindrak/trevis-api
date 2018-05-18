// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/URAWYYA/IdeaProjects/trevis-api/conf/routes
// @DATE:Fri May 18 06:09:06 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  Assets_2: controllers.Assets,
  // @LINE:12
  UserController_1: controllers.UserController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    Assets_2: controllers.Assets,
    // @LINE:12
    UserController_1: controllers.UserController
  ) = this(errorHandler, HomeController_0, Assets_2, UserController_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_2, UserController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add""", """controllers.UserController.save"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """send/""" + "$" + """device_token<[^/]+>""", """controllers.UserController.sendNotification(device_token:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mail""", """controllers.UserController.sendMail"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """update/""" + "$" + """name<[^/]+>""", """controllers.UserController.updateByName(name:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """append""", """controllers.UserController.append"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_save2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add")))
  )
  private[this] lazy val controllers_UserController_save2_invoker = createInvoker(
    UserController_1.save,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "save",
      Nil,
      "POST",
      this.prefix + """add""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UserController_sendNotification3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("send/"), DynamicPart("device_token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_sendNotification3_invoker = createInvoker(
    UserController_1.sendNotification(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "sendNotification",
      Seq(classOf[String]),
      "POST",
      this.prefix + """send/""" + "$" + """device_token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_UserController_sendMail4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mail")))
  )
  private[this] lazy val controllers_UserController_sendMail4_invoker = createInvoker(
    UserController_1.sendMail,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "sendMail",
      Nil,
      "POST",
      this.prefix + """mail""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_UserController_updateByName5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("update/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_updateByName5_invoker = createInvoker(
    UserController_1.updateByName(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateByName",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """update/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_UserController_append6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("append")))
  )
  private[this] lazy val controllers_UserController_append6_invoker = createInvoker(
    UserController_1.append,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "append",
      Nil,
      "PUT",
      this.prefix + """append""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_2.versioned(path, file))
      }
  
    // @LINE:12
    case controllers_UserController_save2_route(params@_) =>
      call { 
        controllers_UserController_save2_invoker.call(UserController_1.save)
      }
  
    // @LINE:14
    case controllers_UserController_sendNotification3_route(params@_) =>
      call(params.fromPath[String]("device_token", None)) { (device_token) =>
        controllers_UserController_sendNotification3_invoker.call(UserController_1.sendNotification(device_token))
      }
  
    // @LINE:16
    case controllers_UserController_sendMail4_route(params@_) =>
      call { 
        controllers_UserController_sendMail4_invoker.call(UserController_1.sendMail)
      }
  
    // @LINE:18
    case controllers_UserController_updateByName5_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_UserController_updateByName5_invoker.call(UserController_1.updateByName(name))
      }
  
    // @LINE:20
    case controllers_UserController_append6_route(params@_) =>
      call { 
        controllers_UserController_append6_invoker.call(UserController_1.append)
      }
  }
}
