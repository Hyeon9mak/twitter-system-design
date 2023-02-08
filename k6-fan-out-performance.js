import http from 'k6/http';
import { check } from 'k6';

export const options = {
  vus: 1,
  duration: '10s',
};

export default function () {
  const responses = http.batch([
    ['GET', 'http://localhost:8080/api/v1/feeds?user-id=104', null, null],
    ['GET', 'http://localhost:8080/api/v1/feeds?user-id=105', null, null],
  ])

  check(responses[0], {
    'same response': (r) => r.body === responses[1].body,
  });
}
