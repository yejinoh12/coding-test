import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

#print(graph)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(graph, x, y):

  queue = deque()
  queue.append((x, y))
  graph[x][y] = 0
  count = 0

  while queue:
    x, y = queue.popleft()
    count+=1

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      if graph[nx][ny] == 1:
        queue.append((nx, ny))
        graph[nx][ny] = 0
  return count


count = 0
max = 0

for i in range(n):
  for j in range(m):
    if graph[i][j] == 1:
      count += 1
      temp = bfs(graph, i, j)
      if temp > max:
        max = temp

print(count)
print(max)