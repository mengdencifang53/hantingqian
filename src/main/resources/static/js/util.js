var utils = {
    // 校验表单是否为空
    validate: function (data, except) {
        for (var item in data) {
            // 校验表单,except为排除项
            if (!this.contains(except, item)) {
                if (data[item].toString().trim() == '') return null;
            }
        }
        return data;
    },
    // 校验数组是否包含某元素
    contains: function (arr, obj) {
        var i = arr.length;
        while (i--) {
            if (arr[i] === obj) {
                return true;
            }
        }
        return false;
    },
    // 复制map
    copyMap: function (mapObj) {
        let newMap = {};
        for (var item in mapObj) {
            newMap[item] = mapObj[item];
        }
        return newMap;
    }
}

export default utils
