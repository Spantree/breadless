class UrlMappings {

	static mappings = {

        "/sandwich/$id?" {
            controller = 'sandwich'
            action = [GET: 'show']
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
