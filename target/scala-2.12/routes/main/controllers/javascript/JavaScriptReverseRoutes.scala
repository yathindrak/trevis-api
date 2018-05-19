// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/URAWYYA/IdeaProjects/trevis-api/conf/routes
// @DATE:Sat May 19 20:22:06 IST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

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

  // @LINE:11
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def findById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.findById",
      """
        function(uid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findbyuid/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("uid", uid0))})
        }
      """
    )
  
    // @LINE:19
    def updateByName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateByName",
      """
        function(name0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "update/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0))})
        }
      """
    )
  
    // @LINE:15
    def sendNotification: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.sendNotification",
      """
        function(device_token0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "send/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("device_token", device_token0))})
        }
      """
    )
  
    // @LINE:23
    def append: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.append",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "append"})
        }
      """
    )
  
    // @LINE:17
    def sendMail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.sendMail",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mail"})
        }
      """
    )
  
    // @LINE:13
    def save: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.save",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "add"})
        }
      """
    )
  
    // @LINE:21
    def updateByUID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateByUID",
      """
        function(uid0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "updatebyuid/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("uid", uid0))})
        }
      """
    )
  
  }


}
