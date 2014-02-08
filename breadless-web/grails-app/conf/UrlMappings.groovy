class UrlMappings {

	static mappings = {

        "sandwich/$id?" {
            controller = 'sandwichController'
            action = [GET: 'show']
            parseRequest = true
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
