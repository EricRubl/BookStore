import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../types';
import ClientURL from '../urls';

@Injectable()
export class ClientsService {

  constructor(private httpClient: HttpClient) {}

  getClients() : Observable<Client[]> {
    return this.httpClient.get<Array<Client> > (ClientURL.get);
  }
}
