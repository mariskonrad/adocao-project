export function formatDateWhitHours(date) {
  const time = date.split('T')[1]

  const formatedTime = time.split(':')

  const day = date.split('T')[0]

  const formatedDay = day.split('-')

  return (
    formatedDay[2] +
    '/' +
    formatedDay[1] +
    '/' +
    formatedDay[0] +
    ' - ' +
    formatedTime[0] +
    ':' +
    formatedTime[1] +
    'h'
  )
}
