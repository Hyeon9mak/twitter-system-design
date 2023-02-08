import http from 'k6/http';
import { check } from 'k6';

export const options = {
  vus: 1,
  duration: '60s',
};

export default function () {
  const responses = http.batch([
    ['GET', 'http://localhost:8080/api/v1/feeds?user-id=1', null, null],
    ['GET', 'http://localhost:8080/api/v1/feeds?user-id=10000', null, null],
  ])

  check(responses[0], {
    'same response': (r) => r.body === responses[1].body,
  });
}
