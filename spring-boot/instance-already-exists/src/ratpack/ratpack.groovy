import foo.AppSpringConfig

import static ratpack.spring.Spring.spring
import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json
import ratpack.handling.RequestLogger
import ratpack.exec.Blocking
import ratpack.exec.Promise
import foo.Service

def springRegistry = spring(AppSpringConfig)

ratpack {
    handlers {
		register(springRegistry)
        all(RequestLogger.ncsa())

        all() { Service service ->
        	Blocking.get {
				service.doSomething()
			} then { message ->
				if (message) {
					render message
				} else {
				response.status(404)
				render(json([error: "not_found"]))
				}
			}
        }
    }
}

