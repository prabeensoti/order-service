## USE k8s-config for other configuration before executing it

`https://github.com/prabeensoti/k8s-config`

execute command to deploy on minikube

`minikube kubectl -- apply ./k8s/deployment.yaml`

### OR

`kubectl apply ./k8s/deployment.yaml`

### USE BELOW EXPOSED URL TO ACCESS THE SERVICE

## GET ORDERS

### GET METHOD: microservice.test/order/orders

### RESPONSE BODY:

### `List`

## SAVE ORDER

### POST METHOD: microservice.test/order/orders

### REQUEST BODY:

###  

    "userId":1,
    "paymentType":"PAYPAL",
    "status":"DRAFT",
    "items":[{
        "productId":1,
        "quantity":1,
        "discount":1.0,
        "price":10.0,
        "tax":1.0
    }],
    "shippingAddress":{
        "address1":"Fairfield",
        "address2":"IOWA",
        "city":"IA",
        "state":"IA",
        "zip":52557,
        "country":"USA"
    }

## PAY FOR ORDER

### POST METHOD: microservice.test/order/orders/1/pay

### REQUEST BODY:

### `{"paypalId":"1","bankAccNumber":"123","creditCardNumber":"12345"}`

### RESPONSE BODY:

### `Order Placed Successfully, notification triggered!!`

