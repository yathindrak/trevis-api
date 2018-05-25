// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/URAWYYA/IdeaProjects/trevis-api/conf/routes
// @DATE:Fri May 25 12:52:09 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:9
  Assets_4: controllers.Assets,
  // @LINE:11
  UserController_3: controllers.UserController,
  // @LINE:27
  FriendReqController_0: controllers.FriendReqController,
  // @LINE:33
  FriendsController_2: controllers.FriendsController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:9
    Assets_4: controllers.Assets,
    // @LINE:11
    UserController_3: controllers.UserController,
    // @LINE:27
    FriendReqController_0: controllers.FriendReqController,
    // @LINE:33
    FriendsController_2: controllers.FriendsController
  ) = this(errorHandler, HomeController_1, Assets_4, UserController_3, FriendReqController_0, FriendsController_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_4, UserController_3, FriendReqController_0, FriendsController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAll""", """controllers.UserController.getAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """findbyuid/""" + "$" + """uid<[^/]+>""", """controllers.UserController.findById(uid:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add""", """controllers.UserController.save"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """send/""" + "$" + """device_token<[^/]+>""", """controllers.UserController.sendNotification(device_token:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mail""", """controllers.UserController.sendMail"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """update/""" + "$" + """name<[^/]+>""", """controllers.UserController.updateByName(name:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatebyuid/""" + "$" + """uid<[^/]+>""", """controllers.UserController.updateByUID(uid:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """append""", """controllers.UserController.append"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """saveReq""", """controllers.FriendReqController.save"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllReqs""", """controllers.FriendReqController.getAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """findByReq/""" + "$" + """from_uid<[^/]+>/""" + "$" + """to_uid<[^/]+>""", """controllers.FriendReqController.findByReq(from_uid:String, to_uid:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """saveFrnd""", """controllers.FriendsController.save"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """storeReq/""" + "$" + """uid<[^/]+>""", """controllers.FriendsController.append(uid:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """isFriend/""" + "$" + """current_id<[^/]+>/""" + "$" + """userId<[^/]+>""", """controllers.FriendsController.isFriend(current_id:String, userId:String)"""),
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
    HomeController_1.index,
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
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
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

  // @LINE:11
  private[this] lazy val controllers_UserController_getAll2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAll")))
  )
  private[this] lazy val controllers_UserController_getAll2_invoker = createInvoker(
    UserController_3.getAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getAll",
      Nil,
      "GET",
      this.prefix + """getAll""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserController_findById3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("findbyuid/"), DynamicPart("uid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_findById3_invoker = createInvoker(
    UserController_3.findById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "findById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """findbyuid/""" + "$" + """uid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UserController_save4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add")))
  )
  private[this] lazy val controllers_UserController_save4_invoker = createInvoker(
    UserController_3.save,
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

  // @LINE:17
  private[this] lazy val controllers_UserController_sendNotification5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("send/"), DynamicPart("device_token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_sendNotification5_invoker = createInvoker(
    UserController_3.sendNotification(fakeValue[String]),
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

  // @LINE:19
  private[this] lazy val controllers_UserController_sendMail6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mail")))
  )
  private[this] lazy val controllers_UserController_sendMail6_invoker = createInvoker(
    UserController_3.sendMail,
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

  // @LINE:21
  private[this] lazy val controllers_UserController_updateByName7_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("update/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_updateByName7_invoker = createInvoker(
    UserController_3.updateByName(fakeValue[String]),
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

  // @LINE:23
  private[this] lazy val controllers_UserController_updateByUID8_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatebyuid/"), DynamicPart("uid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_updateByUID8_invoker = createInvoker(
    UserController_3.updateByUID(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateByUID",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """updatebyuid/""" + "$" + """uid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_UserController_append9_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("append")))
  )
  private[this] lazy val controllers_UserController_append9_invoker = createInvoker(
    UserController_3.append,
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

  // @LINE:27
  private[this] lazy val controllers_FriendReqController_save10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("saveReq")))
  )
  private[this] lazy val controllers_FriendReqController_save10_invoker = createInvoker(
    FriendReqController_0.save,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendReqController",
      "save",
      Nil,
      "POST",
      this.prefix + """saveReq""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_FriendReqController_getAll11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllReqs")))
  )
  private[this] lazy val controllers_FriendReqController_getAll11_invoker = createInvoker(
    FriendReqController_0.getAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendReqController",
      "getAll",
      Nil,
      "GET",
      this.prefix + """getAllReqs""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_FriendReqController_findByReq12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("findByReq/"), DynamicPart("from_uid", """[^/]+""",true), StaticPart("/"), DynamicPart("to_uid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FriendReqController_findByReq12_invoker = createInvoker(
    FriendReqController_0.findByReq(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendReqController",
      "findByReq",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """findByReq/""" + "$" + """from_uid<[^/]+>/""" + "$" + """to_uid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_FriendsController_save13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("saveFrnd")))
  )
  private[this] lazy val controllers_FriendsController_save13_invoker = createInvoker(
    FriendsController_2.save,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendsController",
      "save",
      Nil,
      "POST",
      this.prefix + """saveFrnd""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_FriendsController_append14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("storeReq/"), DynamicPart("uid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FriendsController_append14_invoker = createInvoker(
    FriendsController_2.append(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendsController",
      "append",
      Seq(classOf[String]),
      "POST",
      this.prefix + """storeReq/""" + "$" + """uid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_FriendsController_isFriend15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("isFriend/"), DynamicPart("current_id", """[^/]+""",true), StaticPart("/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FriendsController_isFriend15_invoker = createInvoker(
    FriendsController_2.isFriend(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendsController",
      "isFriend",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """isFriend/""" + "$" + """current_id<[^/]+>/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:11
    case controllers_UserController_getAll2_route(params@_) =>
      call { 
        controllers_UserController_getAll2_invoker.call(UserController_3.getAll)
      }
  
    // @LINE:13
    case controllers_UserController_findById3_route(params@_) =>
      call(params.fromPath[String]("uid", None)) { (uid) =>
        controllers_UserController_findById3_invoker.call(UserController_3.findById(uid))
      }
  
    // @LINE:15
    case controllers_UserController_save4_route(params@_) =>
      call { 
        controllers_UserController_save4_invoker.call(UserController_3.save)
      }
  
    // @LINE:17
    case controllers_UserController_sendNotification5_route(params@_) =>
      call(params.fromPath[String]("device_token", None)) { (device_token) =>
        controllers_UserController_sendNotification5_invoker.call(UserController_3.sendNotification(device_token))
      }
  
    // @LINE:19
    case controllers_UserController_sendMail6_route(params@_) =>
      call { 
        controllers_UserController_sendMail6_invoker.call(UserController_3.sendMail)
      }
  
    // @LINE:21
    case controllers_UserController_updateByName7_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_UserController_updateByName7_invoker.call(UserController_3.updateByName(name))
      }
  
    // @LINE:23
    case controllers_UserController_updateByUID8_route(params@_) =>
      call(params.fromPath[String]("uid", None)) { (uid) =>
        controllers_UserController_updateByUID8_invoker.call(UserController_3.updateByUID(uid))
      }
  
    // @LINE:25
    case controllers_UserController_append9_route(params@_) =>
      call { 
        controllers_UserController_append9_invoker.call(UserController_3.append)
      }
  
    // @LINE:27
    case controllers_FriendReqController_save10_route(params@_) =>
      call { 
        controllers_FriendReqController_save10_invoker.call(FriendReqController_0.save)
      }
  
    // @LINE:29
    case controllers_FriendReqController_getAll11_route(params@_) =>
      call { 
        controllers_FriendReqController_getAll11_invoker.call(FriendReqController_0.getAll)
      }
  
    // @LINE:31
    case controllers_FriendReqController_findByReq12_route(params@_) =>
      call(params.fromPath[String]("from_uid", None), params.fromPath[String]("to_uid", None)) { (from_uid, to_uid) =>
        controllers_FriendReqController_findByReq12_invoker.call(FriendReqController_0.findByReq(from_uid, to_uid))
      }
  
    // @LINE:33
    case controllers_FriendsController_save13_route(params@_) =>
      call { 
        controllers_FriendsController_save13_invoker.call(FriendsController_2.save)
      }
  
    // @LINE:35
    case controllers_FriendsController_append14_route(params@_) =>
      call(params.fromPath[String]("uid", None)) { (uid) =>
        controllers_FriendsController_append14_invoker.call(FriendsController_2.append(uid))
      }
  
    // @LINE:37
    case controllers_FriendsController_isFriend15_route(params@_) =>
      call(params.fromPath[String]("current_id", None), params.fromPath[String]("userId", None)) { (current_id, userId) =>
        controllers_FriendsController_isFriend15_invoker.call(FriendsController_2.isFriend(current_id, userId))
      }
  }
}
