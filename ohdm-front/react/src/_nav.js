let items = [
	{
        name: 'Strona Główan',
        icon: 'fa fa-home',
        url: '/'
    },
	{
        name: 'Działki',
        icon: 'fa fa-tree',
        children: [
            {
                name: 'Lista',
                url: '/',
                icon: 'fa fa-list'
            },
            {
                name: 'Mapa',
                url: '/',
                icon: 'fa fa-map-pin'
            }
        ]
    },
]

export default {
    items
};
