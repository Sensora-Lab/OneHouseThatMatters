import {apiUrl} from "../config";

export class Request {
    constructor () {
        this.abortController = new AbortController()
    }

    post (urlSuffix, body = {"":""}, strictUrl = false) {
            return fetch(!strictUrl ? apiUrl + urlSuffix : urlSuffix, {
            signal: this.abortController.signal,
            method: 'POST',
            mode: 'cors',
            headers: {
                'Accept': 'application/json, text/plain, */*, text/html, audio/mp3',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        }).then((res) => {
            return res.json();
        })
    }

    get (urlSuffix, strictUrl = false) {
        return fetch(!strictUrl ? apiUrl + urlSuffix : urlSuffix, {
            signal: this.abortController.signal,
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((res) => {
                   return res.json();
       })
    }

    abort () {
        this.abortController.abort();
    }
}
