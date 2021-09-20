import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../model/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  setBuyOrder(data:any){
    console.log(data);
    let url="http://localhost:8282/api/buyorder";
    const headers={'Content-type':'application/json'}
    const body=JSON.stringify(data);
    return this.http.post(url, body, {headers:headers})
  }

  setSellOrder(data:any){
    console.log(data);
    let url="http://localhost:8282/api/sellorder";
    const headers={'Content-type':'application/json'}
    const body=JSON.stringify(data);
    return this.http.post(url, body, {headers:headers})
  }

  getAllBuyOrders():Observable<Order[]>{
    let url="http://localhost:8282/api/buyorders";
    return this.http.get<Order[]>(url).pipe();
  }

  getAllSellOrders():Observable<Order[]>{
    let url="http://localhost:8282/api/sellorders";
    return this.http.get<Order[]>(url).pipe();
  }

  getAllHistory():Observable<History[]>{
    let url="http://localhost:8282/api/historys";
    return this.http.get<History[]>(url).pipe();
  }
}
