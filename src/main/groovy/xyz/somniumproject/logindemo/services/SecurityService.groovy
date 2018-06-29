package xyz.somniumproject.logindemo.services

import grails.gorm.transactions.Transactional
import org.springframework.stereotype.Service
import xyz.somniumproject.logindemo.commands.CustomException
import xyz.somniumproject.logindemo.commands.MobileUserCommand
import xyz.somniumproject.logindemo.domains.security.User

@Service
@Transactional
class SecurityService {

    MobileUserCommand userAuth(String username, String password) throws CustomException {
        MobileUserCommand mobileReturn = new MobileUserCommand()
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new CustomException(errorType: CustomException.ERROR.VALIDATION_ERROR, messageText: "The user and password cannot be empty...")
        } else {
            try {
                User user = User.findByUsernameAndPassword(username, password)
                if (!user) {
                    throw new CustomException(errorType: CustomException.ERROR.VALIDATION_ERROR, messageText: "The password is not correct...")
                } else {
                    mobileReturn.name = user.name
                    mobileReturn.token = Base64.encoder.encode(user.password.bytes)
                    mobileReturn.profiles = new ArrayList<>()
                    user.profiles.each {
                        mobileReturn.profiles.add(it.description)
                    }
                }
                return mobileReturn

            } catch (Exception e) {
                throw new CustomException(errorType: CustomException.ERROR.SERVER_ERROR, messageText: "Server Failed...")
            }
        }
    }
}
