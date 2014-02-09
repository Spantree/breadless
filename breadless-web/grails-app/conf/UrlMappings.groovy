class UrlMappings {

	static mappings = {

        "/sandwich/vote" {
            controller = 'sandwichVote'
            action = [GET: 'show', POST: 'submit', PUT: 'submit']
            view = '/sandwich/vote'
        }

        "/sandwich/list" {
            controller = 'sandwichList'
            action = [GET: 'show']
            view = 'sandwich/list'

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
