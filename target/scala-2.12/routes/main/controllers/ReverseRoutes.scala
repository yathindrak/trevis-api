// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/URAWYYA/IdeaProjects/trevis-api/conf/routes
// @DATE:Wed May 30 16:08:33 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:49
    def at(file:String): Call = {
    
      (file: @unchecked) match {
      
        // @LINE:49
        case (file) if file == "index.html" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/swagger"), ("file", "index.html"))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "docs/")
      
        // @LINE:51
        case (file)  =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/swagger"))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "docs/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
      
      }
    
    }
  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:31
  class ReverseFriendsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def append(uid:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "storeFrnd/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("uid", uid)))
    }
  
    // @LINE:31
    def getAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllFrnds")
    }
  
    // @LINE:45
    def sendNotify(uuid:String, lat:String, lng:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendPush/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("uuid", uuid)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("lat", lat)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("lng", lng)))
    }
  
    // @LINE:35
    def save(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "saveFrnd")
    }
  
    // @LINE:43
    def deleteFriend(): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "deleteFrnd")
    }
  
    // @LINE:39
    def isFriend(current_id:String, userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "isFriend/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("current_id", current_id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
  }

  // @LINE:11
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def findById(uid:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "findbyuid/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("uid", uid)))
    }
  
    // @LINE:21
    def updateByName(name:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "update/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:17
    def sendNotification(device_token:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "send/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("device_token", device_token)))
    }
  
    // @LINE:47
    def updateLocation(uid:String, latitude:Double, longitude:Double): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "locUpdate/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("uid", uid)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Double]].unbind("latitude", latitude)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Double]].unbind("longitude", longitude)))
    }
  
    // @LINE:19
    def sendMail(email_to:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "mail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email_to", email_to)))
    }
  
    // @LINE:11
    def getAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAll")
    }
  
    // @LINE:15
    def save(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "add")
    }
  
    // @LINE:23
    def updateByUID(uid:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "updatebyuid/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("uid", uid)))
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:50
  class ReverseApiHelpController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:50
    def getResources(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "docs/swagger.json")
    }
  
  }

  // @LINE:27
  class ReverseFriendReqController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def deleteReq(from:String, to:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "deleteReq/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("from", from)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("to", to)))
    }
  
    // @LINE:27
    def save(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "saveReq")
    }
  
    // @LINE:29
    def getAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllReqs")
    }
  
    // @LINE:33
    def findByReq(from_uid:String, to_uid:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "findByReq/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("from_uid", from_uid)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("to_uid", to_uid)))
    }
  
  }


}
