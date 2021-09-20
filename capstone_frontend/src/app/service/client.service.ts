import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Client } from '../model/client';


@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http:HttpClient) { }

  public getAllClients():Observable<Client[]>{
    let url="http://localhost:8282/api/clients";
    return this.http.get<Client[]>(url).pipe();
  }

  public getClientNameByID(id:any):Observable<Client>{

    let url="http://localhost:8282/api/client/"+id;
    return this.http.get<Client>(url).pipe()
    }

    public getClientByCID(id:string):Observable<Client[]>{
      let url="http://localhost:8282/api/clients/custodian/"+id;
    return this.http.get<Client[]>(url).pipe()
    }
}
