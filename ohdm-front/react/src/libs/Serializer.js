class Serializer {
    /**
     * Getting data from any form
     */
    static serialize (node) {
        let out = {}
        node.querySelectorAll('input, select, textarea, [name]').forEach(item => {
            if (item.type === 'checkbox') {
                out[item.name] = item.checked;
            }
            else if (item.type === 'select-multiple'){
                 var value = [];
                 for (var i = 0, l = item.options.length; i < l; i++) {
                     if (item.options[i].selected) {
                         value.push(item.options[i].value);
                     }
                 }
                 out[item.name] = value;
            }
            else {
                out[item.name] = item.value;
            }
        })
        return out;
    }
}

export default Serializer;
