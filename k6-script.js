import http from 'k6/http';

export const options = {
  vus: 1,
  duration: '10s',
};

export default function () {
  http.batch([
    ['GET', 'http://localhost:8080/api/v1/feeds?user-id=1', null, null],
    ['GET', 'http://localhost:8080/api/v1/feeds?user-id=2', null, null],
  ])
}
