import { Component, OnInit } from '@angular/core';
import { ClientsService } from '../service/clients.service';
import { Client } from '../types';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: Client[];
  displayedColumns = ['id', 'name'];

  constructor(private service: ClientsService) { }

  ngOnInit() {
    this.service.getClients().subscribe(resp => {
      this.clients = resp.sort((c1: Client, c2: Client) => c1.id - c2.id);
    })
  }
}
