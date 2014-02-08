import net.spantree.breadless.Role
import net.spantree.breadless.User
import net.spantree.breadless.UserRole

class BootStrap {
    def springSecurityService

    def init = { servletContext ->

        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)


        def user = User.findByUsername("test") ?: new User(
                username: "test",
                password: "test",
                enabled: true,
                accountExpired: false,
                accountLocked: false,
                passwordExpired: false,
        ).save(flush: true)

        if (!user.authorities.contains(adminRole)) {
            UserRole.create(user, adminRole)
        }
        if (!user.authorities.contains(userRole)) {
            UserRole.create(user, userRole)
        }

    }
    def destroy = {
    }
}
