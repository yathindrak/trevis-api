// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/URAWYYA/IdeaProjects/trevis-api/conf/routes
// @DATE:Fri May 25 12:52:09 IST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:33
  class ReverseFriendsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def isFriend: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendsController.isFriend",
      """
        function(current_id0,userId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "isFriend/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("current_id", current_id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId1))})
        }
      """
    )
  
    // @LINE:33
    def save: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendsController.save",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveFrnd"})
        }
      """
    )
  
    // @LINE:35
    def append: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendsController.append",
      """
        function(uid0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "storeReq/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("uid", uid0))})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def findById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.findById",
      """
        function(uid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findbyuid/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("uid", uid0))})
        }
      """
    )
  
    // @LINE:21
    def updateByName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateByName",
      """
        function(name0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "update/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0))})
        }
      """
    )
  
    // @LINE:17
    def sendNotification: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.sendNotification",
      """
        function(device_token0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "send/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("device_token", device_token0))})
        }
      """
    )
  
    // @LINE:25
    def append: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.append",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "append"})
        }
      """
    )
  
    // @LINE:11
    def getAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAll"})
        }
      """
    )
  
    // @LINE:19
    def sendMail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.sendMail",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mail"})
        }
      """
    )
  
    // @LINE:15
    def save: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.save",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "add"})
        }
      """
    )
  
    // @LINE:23
    def updateByUID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateByUID",
      """
        function(uid0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "updatebyuid/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("uid", uid0))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseFriendReqController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def save: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendReqController.save",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveReq"})
        }
      """
    )
  
    // @LINE:29
    def getAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendReqController.getAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllReqs"})
        }
      """
    )
  
    // @LINE:31
    def findByReq: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendReqController.findByReq",
      """
        function(from_uid0,to_uid1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findByReq/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("from_uid", from_uid0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("to_uid", to_uid1))})
        }
      """
    )
  
  }


}
