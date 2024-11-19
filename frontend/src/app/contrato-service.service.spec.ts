import { TestBed } from '@angular/core/testing';

import { ContratoService } from './contrato-service.service';

describe('ContratoServiceService', () => {
  let service: ContratoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContratoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
