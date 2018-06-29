package xyz.somniumproject.logindemo.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import xyz.somniumproject.logindemo.commands.CustomException
import xyz.somniumproject.logindemo.commands.Message
import xyz.somniumproject.logindemo.commands.MobileUserCommand
import xyz.somniumproject.logindemo.commands.UserAuthReturn
import xyz.somniumproject.logindemo.services.SecurityService


@RestController
@RequestMapping("/auth")
class SecurityController {

    @Autowired
    SecurityService securityService

    @RequestMapping("/")
    String index() {
        return "Auth Service index..."
    }

    @RequestMapping("login")
    UserAuthReturn autenticarUsuario(@RequestParam(value = "user", defaultValue = "") String user,
                                     @RequestParam(value = "password", defaultValue = "") String password) {
        UserAuthReturn retorno = new UserAuthReturn()
        try {
            MobileUserCommand usr = securityService.userAuth(user, password)
            retorno.user = usr
            retorno.message = new Message(false, "Auth went good!")
        } catch (CustomException e) {
            retorno.message = new Message(true, e.messageText)
        }

        return retorno
    }

}
