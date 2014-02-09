class UrlMappings {

	static mappings = {

        "/sandwich/vote" {
            //controller = 'sandwich'
            //action = [GET: 'show', POST: 'submit', PUT: 'submit']
            view = '/index'
        }

        "/sandwich/$id?" {
            controller = 'sandwich'
            action = [GET: 'show', POST: 'submit', PUT: 'submit']
        }

        "/sandwich/ingredient/list" {
            controller = 'ingredient'
            action = [GET: 'list']
        }

		"/"(view:"/index")
		"500"(view:'/error')

        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
    }
}
