import http from 'k6/http';

export const options = {
  vus: 1,
  duration: '60s',
};

export default function () {
  http.batch([
    ['GET', 'http://localhost:8080/api/v1/feeds?user-id=10002', null, null],
    ['GET', 'http://localhost:8080/api/v1/feeds?user-id=10003', null, null],
  ])
}
