window.StorageService = {
    getItem: function (key) {
        return localStorage.getItem(key);
    },
    setItem: function (key, value) {
        localStorage.setItem(key, value);
    },
    deleteItem: function (key) {
        localStorage.removeItem(key);
    },
    deleteItems: function (prefix) {
        let instance = this;
        for (let i = 0; i < localStorage.length; i++) {
            let key = localStorage.key(i);
            if (key.includes(prefix)) {
                instance.deleteItem(key);
            }
        }
    },
    clear: function () {
        localStorage.clear();
    }
}
